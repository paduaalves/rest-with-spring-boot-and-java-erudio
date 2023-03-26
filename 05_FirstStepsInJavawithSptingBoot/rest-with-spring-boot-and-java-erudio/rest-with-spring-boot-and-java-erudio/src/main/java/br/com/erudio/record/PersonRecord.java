package br.com.erudio.record;

import java.io.Serial;
import java.io.Serializable;


public record PersonRecord(long id, String firstName, String lastName, String address,
                           String gender) implements Serializable {
    @Serial
    private static final long serialVersionUID = -276717165117137620L;

}
