package com.marber.backend.service;

import com.marber.backend.entities.Cliente;
import com.marber.backend.repository.ClienteRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    // @Autowired // field injection not recommended
    private final ClienteRepository clienteRepository;

    // es lo mismo que: @Autowired  ||  pero se recomienda usarlo
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
   }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) throws ChangeSetPersister.NotFoundException {
        return clienteRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetails) throws ChangeSetPersister.NotFoundException {
        Cliente cliente = getClienteById(id);
        // Set the updated fields of the cliente object
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setDireccion(clienteDetails.getDireccion());
        cliente.setCorreoElectronico(clienteDetails.getCorreoElectronico());
        cliente.setNumeroTelefono(clienteDetails.getNumeroTelefono());
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) throws ChangeSetPersister.NotFoundException {
        Cliente cliente = getClienteById(id);
        clienteRepository.delete(cliente);
    }
}
