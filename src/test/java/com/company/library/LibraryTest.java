package com.company.library;

import com.company.documents.Contract;
import com.company.exceptions.DuplicateIdException;
import com.company.exceptions.DocumentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library<Contract> library;
    private Contract contract1;
    private Contract contract2;

    @BeforeEach
    void setUp() {
        library = new Library<>(Contract.class);
        contract1 = new Contract("C1", 100, "2024-01-01");
        contract2 = new Contract("C2", 200, "2024-02-01");
    }

    @Test
    void testConstructor() {
        assertEquals(Contract.class, library.getDocumentClass());
        assertEquals(0, library.size());
    }

    @Test
    void testPutAndGet() throws DuplicateIdException, DocumentNotFoundException {
        library.put(contract1);

        Contract retrieved = library.get("C1");
        assertEquals(contract1, retrieved);
        assertEquals("C1", retrieved.getId());
        assertEquals(100, retrieved.getCost());
        assertEquals("2024-01-01", retrieved.getDate());
    }

    @Test
    void testPutDuplicateThrowsDuplicateIdException() throws DuplicateIdException {
        library.put(contract1);

        assertThrows(DuplicateIdException.class, () -> {
            library.put(contract1);
        });
    }

    @Test
    void testGetNonExistentThrowsDocumentNotFoundException() {
        assertThrows(DocumentNotFoundException.class, () -> {
            library.get("NONEXISTENT");
        });
    }

    @Test
    void testGetEmptyLibrary() {
        assertThrows(DocumentNotFoundException.class, () -> {
            library.get("ANY_ID");
        });
    }

    @Test
    void testRemove() throws DuplicateIdException, DocumentNotFoundException {
        library.put(contract1);
        library.put(contract2);

        assertEquals(2, library.size());

        Contract removed = library.remove("C1");
        assertEquals(contract1, removed);
        assertEquals(1, library.size());
        assertTrue(library.contains("C2"));
        assertFalse(library.contains("C1"));
    }

    @Test
    void testRemoveNonExistentThrowsDocumentNotFoundException() {
        assertThrows(DocumentNotFoundException.class, () -> {
            library.remove("NONEXISTENT");
        });
    }

    @Test
    void testRemoveFromEmptyLibrary() {
        assertThrows(DocumentNotFoundException.class, () -> {
            library.remove("ANY_ID");
        });
    }

    @Test
    void testContains() throws DuplicateIdException {
        library.put(contract1);

        assertTrue(library.contains("C1"));
        assertFalse(library.contains("C2"));
    }

    @Test
    void testContainsOnEmptyLibrary() {
        assertFalse(library.contains("ANY_ID"));
    }

    @Test
    void testSize() throws DuplicateIdException {
        assertEquals(0, library.size());
        library.put(contract1);
        assertEquals(1, library.size());
        library.put(contract2);
        assertEquals(2, library.size());

        try {
            library.remove("C1");
            assertEquals(1, library.size());
        } catch (DocumentNotFoundException e) {
            fail("Should not throw exception here");
        }
    }

    @Test
    void testMultipleOperationsFlow() throws DuplicateIdException, DocumentNotFoundException {
        assertEquals(0, library.size());

        library.put(contract1);
        assertEquals(1, library.size());
        assertTrue(library.contains("C1"));

        library.put(contract2);
        assertEquals(2, library.size());
        assertTrue(library.contains("C2"));

        Contract retrieved1 = library.get("C1");
        assertEquals(contract1, retrieved1);

        Contract retrieved2 = library.get("C2");
        assertEquals(contract2, retrieved2);

        library.remove("C1");
        assertEquals(1, library.size());
        assertFalse(library.contains("C1"));
        assertTrue(library.contains("C2"));

        assertThrows(DocumentNotFoundException.class, () -> {
            library.get("C1");
        });
    }

    @Test
    void testGetDocumentClass() {
        assertEquals(Contract.class, library.getDocumentClass());
    }

}
