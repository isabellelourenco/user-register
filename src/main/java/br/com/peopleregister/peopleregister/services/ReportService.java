package br.com.peopleregister.peopleregister.services;

import br.com.peopleregister.peopleregister.models.Address;
import br.com.peopleregister.peopleregister.models.Phone;
import br.com.peopleregister.peopleregister.models.User;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    Document document;

    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    PhoneService phoneService;

    public void report(HttpServletResponse response, Long idUser ) {

        try {
            document = new Document();
            User user = userService.findById(idUser);
            Address address = addressService.search(user.getAddress().getId()).get();
            Phone phone = phoneService.search(user.getPhone().getId()).get();

            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // adicionando um parágrafo ao documento
            document.add(new Paragraph("Relatório do Usuário"));

            // adicionando um parágrafo com fonte diferente ao arquivo

            document.add(new Paragraph("Nome: " + user.getName() + ", Sobrenome: " + user.getLastName() + ", Genêro: " + user.getGender(),
                    FontFactory.getFont(FontFactory.COURIER,
                    12)));
            document.add(new Paragraph("CEP: " + address.getZipCode() + ", Endereço: " + address.getAddress()  + ", " +
                    "Complemento: " + address.getComplement() + ", Bairro: " + address.getDistrict() + ", Cidade: " +
                    address.getLocale() + ", UF: " + address.getUf() + ", País: " + address.getCountry(),
                    FontFactory.getFont(FontFactory.COURIER,
                            12)));
            document.add(new Paragraph("DDD: " + phone.getDdd() + ", Número: " + phone.getNumber(),
                    FontFactory.getFont(FontFactory.COURIER,
                            12)));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
            document.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
            document.close();
        } finally {
            document.close();
        }

    }
}


