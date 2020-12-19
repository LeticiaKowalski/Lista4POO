package atvcone;

import java.text.DecimalFormat;

public class Cone {
	
	private double altura;
	private double raio;
	private int tipo;
	
	
	
	public Cone(double altura, double raio, int tipo) {
		setAltura(altura);
		setRaio(raio);
		setTipo(tipo);
	}
	
	

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		if (altura > 0)
			this.altura = altura;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		if (raio > 0)
			this.raio = raio;
	}
	
	public void setTipo(int tipo) {
		if (tipo > 0 && tipo < 4)
			this.tipo = tipo;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	

	public float tipoescolhido() {
		if (getTipo() == 1) {
			return 238.90f;
		}
		if (getTipo() == 2) {
			return 467.98f;
		}
		if (getTipo() == 3) {
			return 758.34f;
		}
		return tipoescolhido();
	}
	
	public double geratriz() {
		return Math.sqrt((raio * raio) + (altura * altura));
	}
	
	public double lateral() {
		return 3.14f * raio * geratriz();
	}
	
	public double areacirculo() {
		return 3.14f * Math.pow(raio, 2);
	}
	
	public double areatotal() {
		return 3.14f * raio * (raio + geratriz());
	}
	
	public double litro() {
		return areatotal() * 3.45f;
	}
	
	public int latas() {
		return  (int) (Math.ceil(litro() / 18));
	}
	
	private String sysmonetario(double x) {
		return (new DecimalFormat("0.00").format(x));
	}
	
	public String precototal() {
		return sysmonetario(tipoescolhido() * latas());
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("- Cone ");
		builder.append("\nRaio: ");
		builder.append(raio);
		builder.append("\nAltura: ");
		builder.append(altura);
		builder.append("\nNível: ");
		builder.append(tipo);
		builder.append("\n-------------------------");
		builder.append("\nGeratriz: ");
		builder.append(geratriz());
		builder.append("\n-------------------------");
		builder.append("\nÁrea do Fundo: ");
		builder.append(areacirculo());
		builder.append("\nÁrea Lateral Cone: ");
		builder.append(lateral());
		builder.append("\nÁrea Total: ");
		builder.append(areatotal());
		builder.append("\n-------------------------");
		builder.append("\nLitros: ");
		builder.append(litro());
		builder.append("\nLatas: ");
		builder.append(Math.round(latas()));
		builder.append("\n-------------------------");
		builder.append("\nPreço Total: ");
		builder.append(precototal());
		return builder.toString();
	}
}