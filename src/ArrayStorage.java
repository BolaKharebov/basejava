/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int index = 0;

    void clear() {
        while (index != 0) {
            storage[index] = null;
            index--;
        }
    }

    void save(Resume r) {
        storage[index] = r;
        index++;
    }

    Resume get(String uuid) {
        Resume resume = new Resume();
        resume.uuid = uuid;
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < index; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
                index--;
                if (i != index) {
                    storage[i] = storage[size()];
                    storage[size()] = null;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] array = new Resume[index];
        for (int i = 0; i < index; i++) {
            array[i] = storage[i];
        }
        return array;
    }

    int size() {
        return index;
    }
}
