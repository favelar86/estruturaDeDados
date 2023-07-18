import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarregarDadosExternos {

    private static String CAMINHO_ARQUIVO = "src/main/resources/Python_M10_support material.csv";

    public List<Cliente> carregarClientesCVS(){

        List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {

            br.readLine(); // Remover o cabeçalho

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0].trim());
                int inadimplente = Integer.parseInt(dados[1].trim());
                int idade = Integer.parseInt(dados[2].trim());
                String sexo = dados[3].trim();
                int dependentes = Integer.parseInt(dados[4].trim());
                String escolaridade = dados[5].trim();
                String estadoCivil = dados[6].trim();
                String salarioAnual = dados[7].trim();
                String tipoCartao = dados[8].trim();
                String mesesDeRelacionamento = dados[9].trim();
                int quantidadeDeProdutos = Integer.parseInt(dados[10].trim());
                int iteracoes = Integer.parseInt(dados[11].trim());
                int mesesInativo = Integer.parseInt(dados[12].trim());
                Double limiteDeCreditos = Double.parseDouble(dados[13].trim());
                Double quantidadeDeTransacoes = Double.parseDouble(dados[14].trim());

                Cliente cliente = new Cliente(  id,
                                                inadimplente,
                                                idade,
                                                sexo,
                                                dependentes,
                                                escolaridade,
                                                estadoCivil,
                                                salarioAnual,
                                                tipoCartao,
                                                mesesDeRelacionamento,
                                                quantidadeDeProdutos,
                                                iteracoes,
                                                mesesInativo,
                                                limiteDeCreditos,
                                                quantidadeDeTransacoes);

                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;

    }
}
