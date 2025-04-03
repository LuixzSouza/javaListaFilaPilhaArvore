package nos;

public class No {

    private int valor;

    private No noEsquerda;
    private No noDireita;

    public No(int valor) {
        this.valor = valor;
    }

    /**
     * @return No return the noEsquerda
     */
    public No getNoEsquerda() {
        return noEsquerda;
    }

    /**
     * @param noEsquerda the noEsquerda to set
     */
    public void setNoEsquerda(No noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

    /**
     * @return No return the noDireita
     */
    public No getNoDireita() {
        return noDireita;
    }

    /**
     * @param noDireita the noDireita to set
     */
    public void setNoDireita(No noDireita) {
        this.noDireita = noDireita;
    }

}
