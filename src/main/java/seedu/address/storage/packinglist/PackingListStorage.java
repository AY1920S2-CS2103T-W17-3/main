package seedu.address.storage.packinglist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.listmanagers.ReadOnlyPackingListManager;

/**
 * The interface Packing list storage.
 */
public interface PackingListStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getPackingListStorageFilePath();

    /**
     * Read packing list optional.
     *
     * @return the optional
     * @throws DataConversionException the data conversion exception
     */
    Optional<ReadOnlyPackingListManager> readPackingList() throws DataConversionException, IOException;

    /**
     * Read packing list optional.
     *
     * @param filePath the file path
     * @return the optional
     * @throws DataConversionException the data conversion exception
     */
    Optional<ReadOnlyPackingListManager> readPackingList(
            Path filePath) throws DataConversionException, IOException;

    void savePackingList(ReadOnlyPackingListManager packingListManager) throws IOException;

    /**
     * Save items.
     *
     * @param packingListManager the packing list manager
     * @param filePath           the file path
     * @throws IOException the io exception
     */
    void savePackingList(ReadOnlyPackingListManager packingListManager, Path filePath) throws IOException;
}
