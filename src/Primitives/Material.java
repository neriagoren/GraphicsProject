package Primitives;

public class Material {
    private double _kd ;
    private double _ks;
    private int _nShininess;

    public  Material(Material material) {
        _kd =material.getKd() ;
        _ks = material.getKs();
        _nShininess = material.getShininess();
    }
    public  Material() {
        _kd = 0;
        _ks = 0;
        _nShininess = 1;
    }
    public  Material(double kd,double ks, int nS){
        _kd = kd;
        _ks = ks;
        _nShininess = nS;
    }
    /**
     * Diffusion attenuation factor getter/setter
     */
    public double getKd() { return this._kd; }
    public void setKd(double kd) { _kd = kd; }

    /**
     * Specular attenuation factor getter/setter
     */
    public double getKs() { return this._ks; }
    public void setKs(double ks) { _ks = ks; }

    /**
     * Shininess level getter/setter
     */
    public int getShininess() { return this._nShininess; }
    public void setShininess(int nShininess) { _nShininess = nShininess; }
}
