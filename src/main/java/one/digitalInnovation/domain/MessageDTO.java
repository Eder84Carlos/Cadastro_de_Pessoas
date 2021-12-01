package one.digitalInnovation.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Mensagem", description = "Mensagem contendo a descriÃ§Ã£o do erro")
public class MessageDTO {

    @ApiModelProperty(value = "Mensagem descritiva do erro", readOnly = true)
    private String mensagem;

    public MessageDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public MessageDTO(){}

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}