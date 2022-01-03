package quadrilateral_winter_project;

import java.text.DecimalFormat;

public class Rational {
	private int p,q;
	private boolean defined;
	DecimalFormat df = new DecimalFormat("#.####");
	
	public Rational() {
		p = 1;
		q = 1;
		defined = true;
	}
	public Rational(int n, int d) {
		if(d == 0) {
			defined = false;
			p = 0;
			q = 1;
		}
		else {
			defined = true;
			if(n < 0 && d < 0) {
				p = Math.abs(n);
				q = Math.abs(d);
				reduce();
			}
			else if(n < 0 || d < 0) {
				p = (-1 * Math.abs(n));
				q = Math.abs(d);
				reduce();
			}
			else {
				p = n;
				q = d;
				reduce();
			}
		}
	}
	public Rational(double d) {
		defined = true;
		d = Double.parseDouble(df.format(d));
		deciToFrac(Math.abs(d));
		if(d < 0) {
			reduce();
			p *= -1;
		}
		else {
			reduce();
		}
	}
	public void setP(int newP) {
		p = newP;
	}
	public void setQ(int newQ) {
		q = newQ;
		if(q != 0) {
			defined = false;
		}
		else {
			defined = true;
		}
	}
	public int getP() {
		return p;
	}
	public int getQ() {
		return q;
	}
	public boolean isDefined() {
		return defined;
	}
	public double decimalValue() {
		return (double)p / q;
	}
	public void deciToFrac(double num) {
		int count = 0;
		while(num - (int)num > .00001) {
			num = num*10;
			count++;
		}
		p = (int)num;
		q = (int)Math.pow(10, count);
	}
	public void reduce() {
		int gcf = this.gcf(p,q);
		q = q / gcf;
		p = p / gcf;
	}
	public int gcf(int num, int denom) {
		for(int i = Math.min(num, denom); i > 0; i--) {
			if(num % i == 0 && denom % i == 0) {
				return i;
			}
		}
		return 1;
	}
	public Rational add(Rational r) {
		int num = (p * r.getQ())+(r.getP() * q);
		int denom = q * r.getQ();
		int numerator = num / gcf(num,denom);
		int denominator = denom / gcf(num,denom);
		return new Rational(numerator,denominator);
	}
	public Rational subtract(Rational r) {
		int num = (p * r.getQ())-(r.getP() * q);
		int denom = q * r.getQ();
		int numerator = num / gcf(num,denom);
		int denominator = denom / gcf(num,denom);
		return new Rational(numerator,denominator);
	}
	public Rational multiply(Rational r) {
		int num = p * r.getP();
		int denom = q * r.getQ();
		int numerator = num / gcf(num,denom);
		int denominator = denom / gcf(num,denom);
		return new Rational(numerator,denominator);
	}
	public Rational divide(Rational r) {
		int num = p * r.getQ();
		int denom = q * r.getP();
		int numerator = num / gcf(num,denom);
		int denominator = denom / gcf(num,denom);
		return new Rational(numerator,denominator);
	}
	public boolean equals(Rational r) {
		return Math.abs(p - r.getP()) < .01 && Math.abs(q - r.getQ()) < .01;
	}
	public String toString() {
		if(defined) {
			return p + "/" + q;
		}
		return "Vertical Line";
	}
}
