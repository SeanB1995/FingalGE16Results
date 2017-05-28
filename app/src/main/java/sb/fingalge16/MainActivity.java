package sb.fingalge16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;

public class MainActivity extends AppCompatActivity {

    private float[] yData = {25.3f, 12.3f};
    private String[] xData = {"Barry Martin", "a"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
