    public String isSubset( long a1[], long a2[], long n, long m) {
        
        HashMap<Long , Long> mp = new HashMap<>();
        for(long i = 0; i < n; i++){
            mp.put(a1[(int)i] , mp.getOrDefault(a1[(int)i] , 0L) + 1);
        }
        for (long i = 0; i < m; i++) {
            if (mp.containsKey(a2[(int) i])) {
                mp.put(a2[(int) i], mp.get(a2[(int) i]) - 1);
                if (mp.get(a2[(int) i]) < 0) {
                    return "No";
                }
            } else {
                return "No";
            }
        }

        return "Yes";
    }
