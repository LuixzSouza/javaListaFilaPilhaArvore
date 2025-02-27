package arvore;

public class Arvore<TIPO extends Comparable<TIPO>> {
    private Elemento<TIPO> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void adicionar(TIPO valor) {
        Elemento<TIPO> novoElemento = new Elemento<>(valor);
        if (raiz == null) {
            this.raiz = novoElemento;
        } else {
            Elemento<TIPO> atual = this.raiz;
            while (true) {
                // Use "< 0" em vez de "== -1", pois compareTo pode retornar outros valores negativos
                if (novoElemento.getValor().compareTo(atual.getValor()) < 0) { 
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda();
                    } else {
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                } else { // valores iguais ou maiores vão para a direita
                    if (atual.getDireita() != null) {
                        atual = atual.getDireita();
                    } else {
                        atual.setDireita(novoElemento);
                        break;
                    }
                }
            }
        }
    }

    public boolean remover(TIPO valor) {
        Elemento<TIPO> atual = this.raiz;
        Elemento<TIPO> paiAtual = null;

        // Procura o elemento a ser removido
        while (atual != null && !atual.getValor().equals(valor)) {
            paiAtual = atual;
            if (valor.compareTo(atual.getValor()) < 0) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }
        if (atual == null) {
            // Elemento não encontrado
            return false;
        }

        // Caso 1: Nó com dois filhos
        if (atual.getEsquerda() != null && atual.getDireita() != null) {
            // Usamos o sucessor in-ordem (menor elemento da subárvore à direita)
            Elemento<TIPO> substituto = atual.getDireita();
            Elemento<TIPO> paiSubstituto = atual;
            while (substituto.getEsquerda() != null) {
                paiSubstituto = substituto;
                substituto = substituto.getEsquerda();
            }
            // Copia o valor do substituto para o nó a ser removido
            atual.setValor(substituto.getValor());
            // Agora, remove o substituto (que terá no máximo um filho à direita)
            if (paiSubstituto == atual) {
                atual.setDireita(substituto.getDireita());
            } else {
                paiSubstituto.setEsquerda(substituto.getDireita());
            }
        } 
        // Caso 2: Nó com apenas filho à esquerda
        else if (atual.getEsquerda() != null) {
            if (paiAtual == null) { // removendo a raiz
                this.raiz = atual.getEsquerda();
            } else if (paiAtual.getEsquerda() == atual) {
                paiAtual.setEsquerda(atual.getEsquerda());
            } else {
                paiAtual.setDireita(atual.getEsquerda());
            }
        } 
        // Caso 3: Nó com apenas filho à direita
        else if (atual.getDireita() != null) {
            if (paiAtual == null) { // removendo a raiz
                this.raiz = atual.getDireita();
            } else if (paiAtual.getEsquerda() == atual) {
                paiAtual.setEsquerda(atual.getDireita());
            } else {
                paiAtual.setDireita(atual.getDireita());
            }
        } 
        // Caso 4: Nó folha (sem filhos)
        else {
            if (paiAtual == null) { // removendo a raiz
                this.raiz = null;
            } else if (paiAtual.getEsquerda() == atual) {
                paiAtual.setEsquerda(null);
            } else {
                paiAtual.setDireita(null);
            }
        }
        return true;
    }

    // Traversal em ordem: Esquerda, Nó, Direita
    public void emOrdem(Elemento<TIPO> atual) {
        if (atual != null) {
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());
        }
    }

    // Pré-ordem: Nó, Esquerda, Direita
    public void preOrdem(Elemento<TIPO> atual) {
        if (atual != null) {
            System.out.println(atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    // Pós-ordem: Esquerda, Direita, Nó
    public void posOrdem(Elemento<TIPO> atual) {
        if (atual != null) {
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println(atual.getValor());
        }
    }

    public Elemento<TIPO> getRaiz() {
        return raiz;
    }

    public void setRaiz(Elemento<TIPO> raiz) {
        this.raiz = raiz;
    }
}
