package zh.yen.novaeducation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class DescriptionFrag extends Fragment {
    View         v;
    PieChartView pieChart, pieChartView;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        v = inflater.inflate ( R.layout.des_frag , container , false );
        pieChart = v.findViewById ( R.id.piechartFirst );
        List<SliceValue> pieData = new ArrayList<> ();
        pieData.add ( new SliceValue ( 70 , Color.BLUE ).setLabel ( "" ) );
        pieData.add ( new SliceValue ( 20 , Color.GRAY ).setLabel ( "" ) );
        pieData.add ( new SliceValue ( 10 , Color.RED ).setLabel ( "" ) );

        PieChartData pieChartData = new PieChartData ( pieData );
        pieChartData.setHasLabels ( true ).setValueLabelTextSize ( 14 );
        pieChartData.setHasCenterCircle ( true ).setCenterText1 ( "$16800" ).setCenterText1FontSize ( 12 ).setCenterText1Color ( Color.parseColor ( "#0097A7" ) );
        pieChart.setPieChartData( pieChartData );

        return v;
    }

    public void setPieChart(){
        pieChartView = v.findViewById ( R.id.piechartSecond );
        List<SliceValue> pie = new ArrayList<> ();
        pie.add ( new SliceValue ( 60 , Color.GREEN ).setValue ( Float.parseFloat ( "" ) ) );
        pie.add ( new SliceValue ( 40 , Color.RED).setValue ( Float.parseFloat ( "" ) ) );

        PieChartData pieChartV = new PieChartData (pie);
        pieChartV.setHasLabels ( true ).setValueLabelTextSize ( 14 );
        pieChartV.setHasCenterCircle ( true ).setCenterText1 ( "$16800" ).setCenterText1FontSize ( 12 ).setCenterText1Color ( Color.parseColor ( "#0097A7" ) );

    }
}
