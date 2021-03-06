package sb.fingalge16;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private float[] yData = {25.3f, 12.3f};
    private String[] xData = {"Barry Martin", "a"};
    PieChart pieChart;
    Button winner;

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

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                int pos1 = e.toString().indexOf("sum");
                String result = e.toString().substring(pos1 + 7);

                for (int i = 0; i > yData.length; i++){
                    if (yData[i] == Float.parseFloat(result)){
                        pos1 = i;
                        break;
                    }
                }
                String contender = xData[pos1+1];
                Toast.makeText(MainActivity.this, "contender" + contender + "\n" + "Percent" + result, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected() {

            }
        });

    winbut();

    }

    private void addDataSet(PieChart pie) {
        ArrayList<PieEntry> xAxis = new ArrayList<>();
        ArrayList<String> yAxis = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            xAxis.add(new PieEntry(yData[i] , i));
        }

        for(int i = 0; i < xData.length; i++){
            yAxis.add(xData[i]);
        }

        PieDataSet pieDS = new PieDataSet(xAxis, "KSJ");
        pieDS.setSliceSpace(5);
        pieDS.setValueTextSize(10);

        ArrayList<Integer> colour = new ArrayList<>();
        colour.add(Color.GRAY);
        colour.add(Color.CYAN);
        colour.add(Color.RED);
        colour.add(Color.YELLOW);
        colour.add(Color.BLUE);
        colour.add(Color.GREEN);

        pieDS.setColors(colour);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(pieDS);
        pieChart.setData(pieData);
        pieChart.invalidate();



    }

    public void winbut(){
        winner = (Button)findViewById(R.id.button2);
        winner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
