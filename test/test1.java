public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_graph, container, false);
        DataPoint[] data = toDataPointArray(xAxisData, yAxisData);
        graph = (GraphView) v.findViewById(R.id.graph);
        Viewport vp = graph.getViewport();
        GridLabelRenderer glr = graph.getGridLabelRenderer();
        glr.setVerticalAxisTitle(yAxisLabel);
        vp.setYAxisBoundsManual(true);
        vp.setMinY(0);
        vp.setMaxY(getMax()*1.10);
        vp.setXAxisBoundsManual(true);
        vp.setMinX(xAxisData[0].getTime());
        vp.setMaxX(xAxisData[4].getTime());
        glr.setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        glr.setNumHorizontalLabels(5);
        glr.setHorizontalLabelsAngle(135);
        glr.setLabelsSpace(20);
        glr.setHumanRounding(false);
        vp.setScrollable(true);
        if(isBar){
            BarGraphSeries series = new BarGraphSeries<>(data);
            series.setDrawValuesOnTop(false);
            series.setColor(getResources().getColor(R.color.colorGraph));
            series.setSpacing(60);
            graph.addSeries(series);
        } else {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(data);
            series.setColor(getResources().getColor(R.color.colorGraph));
            series.setDrawDataPoints(true);
            series.setThickness(8);
            graph.addSeries(series);
        }
        return v;
    }
