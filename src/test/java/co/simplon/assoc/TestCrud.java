package co.simplon.assoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import co.simplon.assoc.model.Adherent;
import co.simplon.assoc.repository.IAdherent;
import co.simplon.assoc.service.AdherentService;

public class TestCrud {
	
	@Mock
	private IAdherent adherentTest;
	
	@InjectMocks
	private AdherentService adherentServiceTest;
	
	private Adherent adherent1 = new Adherent();
	private Adherent adherent2 = new Adherent();
	private Adherent adherent3 = new Adherent();
	
	@Before
	public void initialize() {
		MockitoAnnotations.initMocks(this);
		
		adherent1.setId(1L);
		adherent1.setNom("test1");
		adherent2.setId(1L);
		adherent2.setNom("test2");
		adherent3.setId(1L);
		adherent3.setNom("test3");
	}
	
	@Test
	public void testGetAll() throws Exception {
		given(adherentTest.findAll()).willReturn(Arrays.asList(adherent1, adherent2, adherent3));
		List<Adherent> result = (List<Adherent>)  adherentServiceTest.listerAdherents();
		assertThat(result).hasSize(3);
		resultatAttendu(result.get(0));
		verify(adherentTest, times(1)).findAll();
	}
	
	
	 @Test
	 public void testInsert() throws Exception {
		 given(adherentTest.save(adherent1)).willReturn(adherent1);
		 Adherent result = adherentServiceTest.creerAdherent(adherent1);
		 resultatAttendu(result);
		 verify(adherentTest, times(1)).save(adherent1);
	 }
	
	 
	private void resultatAttendu(Adherent adherent) {
	     assertThat(adherent.getId()).isInstanceOf(Long.class);
	     assertThat(adherent.getId()).isEqualTo(1);
	     assertThat(adherent.getNom()).isEqualTo("test1");
	}
	

}
