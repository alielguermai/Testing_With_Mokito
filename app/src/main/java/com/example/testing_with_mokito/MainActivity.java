package com.example.testing_with_mokito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public interface CalculatorService {
        public double add(double input1, double input2);
        public double sous(double input1, double input2);
        public double multi(double input1, double input2);
        public double div(double input1, double input2);
    }
    public static class CalculatorApplication {
        private CalculatorService calcService;
        public void setCalculatorService(CalculatorService calcService){
            this.calcService = calcService;
        }
        public double add(double input1, double input2){
            return calcService.add(input1, input2);
        }
        public double sous(double input1, double input2){
            return calcService.sous(input1, input2);
        }
        public double multi(double input1, double input2){
            return calcService.multi(input1, input2);
        }
        public double div(double input1, double input2){
            return calcService.div(input1, input2);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RunWIth(MockitoJUnitRunner.class)
    public class CalculatorApplicationTester {
        @InjectMocks
        CalculatorApplication calculatorApplication = new CalculatorApplication();
        @Mock
        CalculatorService calcService;
        @Test
        public void testAdd(){
            when(calcService.add(10.0,20.0)).thenReturn(30.00);
            Assert.assertEquals(calculatorApplication.add(10.0, 20.0),30.0,0);

        }
    }
}
