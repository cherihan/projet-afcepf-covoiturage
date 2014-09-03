package fr.afcepf.atod21.coVoiturage.business.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListTrajetsDto {

	private List<TrajetDto> listeTrajetsDto;

	public List<TrajetDto> getListeTrajetsDto() {
		return listeTrajetsDto;
	}

	public void setListeTrajetsDto(List<TrajetDto> listeTrajetsDto) {
		this.listeTrajetsDto = listeTrajetsDto;
	}

	public ListTrajetsDto() {
		super();
	}

	public ListTrajetsDto(List<TrajetDto> listeTrajetsDto) {
		super();
		this.listeTrajetsDto = listeTrajetsDto;
	}

	@Override
	public String toString() {
		return "ListTrajetsDto [listeTrajetsDto=" + listeTrajetsDto + "]";
	}
	
	
}
