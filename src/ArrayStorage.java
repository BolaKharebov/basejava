/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int resumeCount = 0;

    void clear() {
        for (int i = 0; i < resumeCount; i++) {
            storage[i] = null;
        }
        resumeCount = 0;
    }

    void save(Resume r) {
        storage[resumeCount++] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < resumeCount; i++) {
            if(storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < resumeCount; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = storage[--resumeCount];
                storage[resumeCount] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes = new Resume[resumeCount];
        for (int i = 0; i < resumeCount; i++) {
            allResumes[i] = storage[i];
        }
        return allResumes;
    }

    int size() {
        return resumeCount;
    }
}
