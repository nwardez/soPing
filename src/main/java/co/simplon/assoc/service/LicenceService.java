package co.simplon.assoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.assoc.repository.ILicence;

@Service
public class LicenceService {

	@Autowired
	private ILicence iLicence;
}
