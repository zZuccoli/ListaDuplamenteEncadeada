public class Main {
    public static class ListaDuplamenteEncadeada {
        private No origem;

        public ListaDuplamenteEncadeada() {
            this.origem = null;
        }

        private class No {
            private Integer elemento;
            private No proximo;
            private No anterior;

            public No(Integer elemento) {
                this.elemento = elemento;
                this.proximo = null;
                this.anterior = null;
            }

            public Integer getElemento() {
                return elemento;
            }

            public No getProximo() {
                return proximo;
            }

            public void setProximo(No proximo) {
                this.proximo = proximo;
            }

            public No getAnterior() {
                return anterior;
            }

            public void setAnterior(No anterior) {
                this.anterior = anterior;
            }
        }

        public void exibirElementos() {
            if (origem == null) {
                System.out.println("Não existem elementos na lista.");
            } else {
                No aux = origem;
                while (aux != null) {
                    System.out.println(aux.getElemento());
                    aux = aux.getProximo();
                }
            }
            System.out.println("----------------------- " );
        }

        public void adicionarFim(Integer elemento) {
            No novoNo = new No(elemento);
            if (origem == null) {
                origem = novoNo;
            } else {
                No aux = origem;
                while (aux.getProximo() != null) {
                    aux = aux.getProximo();
                }
                aux.setProximo(novoNo);
                novoNo.setAnterior(aux);
            }
        }

        public void adicionarInicio(Integer elemento) {
            No novoNo = new No(elemento);
            if (origem != null) {
                novoNo.setProximo(origem);
                origem.setAnterior(novoNo);
            }
            origem = novoNo;
        }

        public void adicionarPosicao(Integer elemento, int posicao) {
            if (posicao >= 0) {
                int cont = 0;
                No atual = origem;
                No anterior = null;
                No novoNo = new No(elemento);
                while (atual != null && cont < posicao) {
                    anterior = atual;
                    atual = atual.getProximo();
                    cont++;
                }
                if (cont == posicao) {
                    if (anterior == null) {
                        adicionarInicio(elemento);
                    } else {
                        novoNo.setProximo(atual);
                        novoNo.setAnterior(anterior);
                        anterior.setProximo(novoNo);
                        if (atual != null) {
                            atual.setAnterior(novoNo);
                        }
                    }
                } else {
                    System.out.println("Posição indisponível.");
                }
            } else {
                System.out.println("Informe uma posição válida.");
            }
        }

        public void removerElemento(Integer elemento) {
            No atual = origem;
            while (atual != null) {
                if (atual.getElemento().equals(elemento)) {
                    if (atual.getAnterior() != null) {
                        atual.getAnterior().setProximo(atual.getProximo());
                    } else {
                        origem = atual.getProximo();
                    }
                    if (atual.getProximo() != null) {
                        atual.getProximo().setAnterior(atual.getAnterior());
                    }
                }
                atual = atual.getProximo();
            }
        }

        public void removerTodasOcorrencias(Integer elemento) {
            No atual = origem;
            while (atual != null) {
                if (atual.getElemento().equals(elemento)) {
                    if (atual.getAnterior() != null) {
                        atual.getAnterior().setProximo(atual.getProximo());
                    } else {
                        origem = atual.getProximo();
                    }
                    if (atual.getProximo() != null) {
                        atual.getProximo().setAnterior(atual.getAnterior());
                    }
                }
                atual = atual.getProximo();
            }
        }

        public void removerInicio() {
            if (origem != null) {
                origem = origem.getProximo();
                if (origem != null) {
                    origem.setAnterior(null);
                }
            } else {
                System.out.println("Não existem elementos na lista.");
            }
        }

        public void removerFim() {
            if (origem != null) {
                No atual = origem;
                while (atual.getProximo() != null) {
                    atual = atual.getProximo();
                }
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(null);
                } else {
                    origem = null;
                }
            }
        }

        public void removerPosicao(int posicao) {
            if (posicao >= 0) {
                int cont = 0;
                No atual = origem;
                while (atual != null && cont < posicao) {
                    atual = atual.getProximo();
                    cont++;
                }
                if (atual != null) {
                    if (atual.getAnterior() != null) {
                        atual.getAnterior().setProximo(atual.getProximo());
                    } else {
                        origem = atual.getProximo();
                    }
                    if (atual.getProximo() != null) {
                        atual.getProximo().setAnterior(atual.getAnterior());
                    }
                } else {
                    System.out.println("A posição não existe na lista.");
                }
            } else {
                System.out.println("Informe uma posição válida.");
            }
        }

        public boolean buscar(Integer elemento) {
            No atual = origem;
            while (atual != null) {
                if (atual.getElemento().equals(elemento)) {
                    System.out.println("O elemento foi encontrado!");
                    return true;
                }
                atual = atual.getProximo();
            }
            System.out.println("O elemento não foi encontrado!");

            return false;

        }

        public Integer maior() {
            if (origem == null) {
                return null;
            }
            No atual = origem;
            Integer maior = atual.getElemento();
            while (atual != null) {
                if (atual.getElemento() > maior) {
                    maior = atual.getElemento();
                }
                atual = atual.getProximo();
            }
            return maior;
        }

        public Integer menor() {
            if (origem == null) {
                return null;
            }
            No atual = origem;
            Integer menor = atual.getElemento();
            while (atual != null) {
                if (atual.getElemento() < menor) {
                    menor = atual.getElemento();
                }
                atual = atual.getProximo();
            }
            return menor;
        }

        public double media() {
            if (origem == null) {
                return 0.0;
            }
            int soma = 0;
            int quantidade = 0;
            No atual = origem;
            while (atual != null) {
                soma += atual.getElemento();
                quantidade++;
                atual = atual.getProximo();
            }
            return (double) soma / quantidade;
        }

        public int quantidade() {
            int quantidade = 0;
            No atual = origem;
            while (atual != null) {
                quantidade++;
                atual = atual.getProximo();
            }
            return quantidade;
        }
    }
}
