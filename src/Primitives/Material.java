package Primitives;

public class Material {
    private double _kd ;
    private double _ks;
    private int _nShininess;

    public  Material(Material material) {
        this._kd =material.getKd() ;
        this._ks = material.getKs();
        this._nShininess = material.getShininess();
    }
    public  Material() {
        this._kd = 0;
        this._ks = 0;
        this._nShininess = 1;
    }
    public  Material(double kd,double ks, int nS){
        this._kd = kd;
        this._ks = ks;
        this._nShininess = nS;
    }
    /**
     * Diffusion attenuation factor getter/setter
     */
    public double getKd() { return this._kd; }
    public void setKd(double kd) { this._kd = kd; }

    /**
     * Specular attenuation factor getter/setter
     */
    public double getKs() { return this._ks; }
    public void setKs(double ks) { this._ks = ks; }

    /**
     * Shininess level getter/setter
     */
    public int getShininess() { return this._nShininess; }
    public void setShininess(int nShininess) { this._nShininess = nShininess; }
}
