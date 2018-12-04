private int getMax() {
        if (yAxisData.length > 0) {
            int max = (int) yAxisData[0];
            for (int i = 1; i < yAxisData.length; i++) {
                if (yAxisData[i] > max)
                    max = (int) yAxisData[i];
            }
            return max;
        } else {
            return 10;
        }
    }
