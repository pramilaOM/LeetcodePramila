class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();
        for (String currFolder : folder) {
            boolean subFolder = false;
            String tempFolder = currFolder;
            while (!currFolder.isEmpty()) {
                int lastPosition = currFolder.lastIndexOf("/");
                currFolder = currFolder.substring(0, lastPosition);
                if (folderSet.contains(currFolder)) {
                    subFolder = true;
                    break;
                }
            }
            if (!subFolder) {
                result.add(tempFolder);
            }
        }
        return result;
    }
}