//master test
private DataPoint[] toDataPointArray(Date[] xAxis, double[] yAxis){
        ArrayList<DataPoint> datalist = new ArrayList<DataPoint>();
        for(int i = 0; i < xAxis.length; i++){
            datalist.add(new DataPoint (xAxis[i], yAxis[i]));
        }
        DataPoint[] data = new DataPoint[datalist.size()];
        data = datalist.toArray(data);
        return data;
    }
    
