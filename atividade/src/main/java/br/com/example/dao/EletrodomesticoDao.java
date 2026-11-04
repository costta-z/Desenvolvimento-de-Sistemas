package br.com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.example.conexao.Conexao;
import br.com.example.modelo.Eletrodomestico;

public class EletrodomesticoDao {

    public boolean cadastrar(Eletrodomestico eletrodomestico) {
        String sql = "INSERT INTO eletrodomestico(nome, marca, voltagem, preco) VALUES(?,?,?,?)";

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, eletrodomestico.getNome());
            comando.setString(2, eletrodomestico.getMarca());
            comando.setString(3, eletrodomestico.getVoltagem());
            comando.setDouble(4, eletrodomestico.getPreco());

            comando.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Eletrodomestico> listar() {
        ArrayList<Eletrodomestico> eletrodomesticos = new ArrayList<>();

        String sql = "SELECT id, nome, marca, voltagem, preco FROM eletrodomestico ORDER BY id";

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Eletrodomestico eletrodomestico = new Eletrodomestico();

                eletrodomestico.setId(resultado.getInt("id"));
                eletrodomestico.setNome(resultado.getString("nome"));
                eletrodomestico.setMarca(resultado.getString("marca"));
                eletrodomestico.setVoltagem(resultado.getString("voltagem"));
                eletrodomestico.setPreco(resultado.getDouble("preco"));

                eletrodomesticos.add(eletrodomestico);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return eletrodomesticos;
    }

    public Eletrodomestico buscar(int id) {
        String sql = "SELECT id, nome, marca, voltagem, preco FROM eletrodomestico WHERE id=?";

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    return new Eletrodomestico(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("marca"),
                        resultado.getString("voltagem"),
                        resultado.getDouble("preco")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }

        return null;
    }

    public boolean alterar(int id, String nome, String marca, String voltagem, double preco) {
        String sql = "UPDATE eletrodomestico SET nome=?, marca=?, voltagem=?, preco=? WHERE id=?";

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, nome);
            comando.setString(2, marca);
            comando.setString(3, voltagem);
            comando.setDouble(4, preco);
            comando.setInt(5, id);

            return comando.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
            return false;
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM eletrodomestico WHERE id=?";

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            return comando.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
            return false;
        }
    }
}