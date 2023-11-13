package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sprint4bigodes.model.Bicicleta;

public class BicicletaDao {

    public void cadastrarBicicleta(Bicicleta bicicleta) {
        String sql = "INSERT INTO Bicicleta (marca, numeroSerie, modelo, roubada) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bicicleta.getMarca());
            preparedStatement.setString(2, bicicleta.getNumeroSerie());
            preparedStatement.setString(3, bicicleta.getModelo());
            preparedStatement.setString(4, bicicleta.isRoubada() ? "S" : "N");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar bicicleta", e);
        }
    }

    public Bicicleta consultarBicicleta(Long id) {
        String sql = "SELECT * FROM Bicicleta WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarBicicleta(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar bicicleta", e);
        }

        return null;
    }

    public List<Bicicleta> listarBicicletas() {
        List<Bicicleta> bicicletas = new ArrayList<>();
        String sql = "SELECT * FROM Bicicleta";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                bicicletas.add(criarBicicleta(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar bicicletas", e);
        }

        return bicicletas;
    }

    private Bicicleta criarBicicleta(ResultSet resultSet) throws SQLException {
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setId(resultSet.getLong("id"));
        bicicleta.setMarca(resultSet.getString("marca"));
        bicicleta.setNumeroSerie(resultSet.getString("numeroSerie"));
        bicicleta.setModelo(resultSet.getString("modelo"));
        bicicleta.setRoubada("S".equals(resultSet.getString("roubada")));
        return bicicleta;
    }
}