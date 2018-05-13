package co.simplon.assoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.repository.ICotisation;

@Service
public class CotisationService {

	@Autowired
	private ICotisation iCotisation;
}
