public class Cliente implements Comparable<Cliente> {

    private Integer id;
    private int inadimplente;
    private Integer idade;
    private String sexo;
    private Integer dependentes;
    private String escolaridade;
    private String estadoCivil;
    private String salarioAnual;
    private String tipoCartao;
    private String mesesDeRelacionamento;
    private Integer quantidadeDeProdutos;
    private Integer iteracoes;
    private Integer mesesInativo;
    private Double limiteDeCreditos;
    private Double quantidadeDeTransacoes;

    public Cliente(Integer id, int inadimplente, Integer idade, String sexo, Integer dependentes, String escolaridade, String estadoCivil, String salarioAnual, String tipoCartao, String mesesDeRelacionamento, Integer quantidadeDeProdutos, Integer iteracoes, Integer mesesInativo, Double limiteDeCreditos, Double quantidadeDeTransacoes) {
        this.id = id;
        this.inadimplente = inadimplente;
        this.idade = idade;
        this.sexo = sexo;
        this.dependentes = dependentes;
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.salarioAnual = salarioAnual;
        this.tipoCartao = tipoCartao;
        this.mesesDeRelacionamento = mesesDeRelacionamento;
        this.quantidadeDeProdutos = quantidadeDeProdutos;
        this.iteracoes = iteracoes;
        this.mesesInativo = mesesInativo;
        this.limiteDeCreditos = limiteDeCreditos;
        this.quantidadeDeTransacoes = quantidadeDeTransacoes;
    }

    public Integer getId() {
        return id;
    }

    public int getInadimplente() {
        return inadimplente;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getSalarioAnual() {
        return salarioAnual;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public String getMesesDeRelacionamento() {
        return mesesDeRelacionamento;
    }

    public Integer getQuantidadeDeProdutos() {
        return quantidadeDeProdutos;
    }

    public Integer getIteracoes() {
        return iteracoes;
    }

    public Integer getMesesInativo() {
        return mesesInativo;
    }

    public Double getLimiteDeCreditos() {
        return limiteDeCreditos;
    }

    public Double getQuantidadeDeTransacoes() {
        return quantidadeDeTransacoes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", inadimplente=" + inadimplente +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", dependentes=" + dependentes +
                ", escolaridade='" + escolaridade + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", salarioAnual=" + salarioAnual +
                ", tipoCartao='" + tipoCartao + '\'' +
                ", mesesDeRelacionamento=" + mesesDeRelacionamento +
                ", quantidadeDeProdutos=" + quantidadeDeProdutos +
                ", iteracoes=" + iteracoes +
                ", mesesInativo=" + mesesInativo +
                ", limiteDeCreditos=" + limiteDeCreditos +
                ", quantidadeDeTransacoes=" + quantidadeDeTransacoes +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente that = (Cliente) o;

        if (!id.equals(that.id)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    @Override
    public int compareTo(Cliente outroCliente) {

        if (this.id < outroCliente.id) {
            return -1;
        }
        else if (this.id > outroCliente.id) {
            return 1;
        }

        return 0;
    }

}
