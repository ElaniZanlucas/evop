package construcao;
import java.lang.Math;

public class Calcular {

  public static float duasCasasDecimais(float value) {
    return (float) (Math.round(value * 100.0) / 100.0);
  }

  public static int inteiro(float value) {
    return (int) (Math.ceil(value));
  }

  public static String tempo(float value) {
    int minutos = inteiro(duasCasasDecimais((value % 1) * 60));
    int horas = (int) (value);
    return String.valueOf(horas) + "h" + String.valueOf(minutos) + "min";
  }
}