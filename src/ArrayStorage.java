/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int resumes = 0;

    void clear() {
        for (int i = 0; i <= resumes; i++) {
            storage[resumes--] = null;
        }
    }

    void save(Resume r) {
        storage[resumes++] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < resumes; i++) {
            if(storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < resumes; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = storage[--resumes];
                storage[resumes] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[resumes];
        for (int i = 0; i < resumes; i++) {
            allResumes[i] = storage[i];
        }
        return allResumes;
    }

    int size() {
        return resumes;
    }
}
