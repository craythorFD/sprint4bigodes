package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.BicicletaDao;
import br.com.fiap.sprint4bigodes.model.Bicicleta;

public class BicicletaService {

    private final BicicletaDao bicicletaDAO = new BicicletaDao();

    public void cadastrarBicicleta(Bicicleta bicicleta) {
        bicicletaDAO.cadastrarBicicleta(bicicleta);
    }

    public Bicicleta consultarBicicleta(Long id) {
        return bicicletaDAO.consultarBicicleta(id);
    }

    public List<Bicicleta> listarBicicletas() {
        return bicicletaDAO.listarBicicletas();
    }


}
