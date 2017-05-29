package sb.fingalge16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private float[] yData = {25.3f, 12.3f};
    private String[] xData = {"Barry Martin", "a"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = (PieChart) findViewById(R.id.idPieChart);

        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Fingal GE");
        pieChart.setCenterTextSize(10);

        addDataSet(pieChart);



    }

    private void addDataSet(PieChart pie) {
        ArrayList<PieEntry> xAxis = new ArrayList<>();
        ArrayList<String> yAxis = new ArrayList<>();
    }
}
