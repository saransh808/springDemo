package com.example.demo.serviceImpl.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.userDTOs.UserDetailsCarryDTO;
import com.example.demo.dto.userDTOs.UserDetailsDTO;
import com.example.demo.dto.userDTOs.UserPhoneNumberDTO;
import com.example.demo.entity.user.UserPhoneNumber;
import com.example.demo.entity.user.UserPhoneNumberKey;
import com.example.demo.entity.user.Users;
import com.example.demo.repository.PhoneNumbersRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.utilities.CommonUtility;

@Service
@Transactional
public class UsersServiceImpl {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PhoneNumbersRepository phoneNumbersRepository;

	@Autowired
	private CommonUtility commonUtility;

	public final static Integer FLAG_PRIMARY_PHONE_NUMBER = 1;
	public final static Integer FLAG_SECONDARY_PHONE_NUMBER = 2;
	public final static Integer FLAG_COUNTRY = 3;

	public String user(UserDetailsDTO userDetails) {

		Users user = new Users();
		user.setUserIdPk(userDetails.getUser().getUserIdPk());
		user.setUserFirstName(userDetails.getUser().getUserFirstName());
		user.setUserMiddleName(userDetails.getUser().getUserMiddleName());
		user.setUserLastName(userDetails.getUser().getUserLastName());
		user.setEmail(userDetails.getUser().getEmail());
		user.setDateOfBirth(userDetails.getUser().getDateOfBirth());
		user.setTimeStmpAdd(LocalDateTime.now());
		usersRepository.save(user);

		UserDetailsCarryDTO carryDTO = new UserDetailsCarryDTO();
		carryDTO.setUserIdPkGenerated(user.getUserIdPk());
		carryDTO.setTimeStmpAdd(user.getTimeStmpAdd());
		this.savePhoneNumbers(userDetails.getPhoneNumbers(), carryDTO);
		return null;

	}

	private void savePhoneNumbers(List<UserPhoneNumberDTO> phNumbers, UserDetailsCarryDTO carryDTO) {
		phoneNumbersRepository.deletePhoneNumbersByUserId(carryDTO.getUserIdPkGenerated());
		List<UserPhoneNumber> phoneNumbers = new ArrayList<UserPhoneNumber>();
		if (phNumbers != null && !phNumbers.isEmpty()) {
			for (UserPhoneNumberDTO listObj : phNumbers) {

				UserPhoneNumber phone = new UserPhoneNumber();
				UserPhoneNumberKey key = new UserPhoneNumberKey();

				key.setUserIdRef(carryDTO.getUserIdPkGenerated());
				if (listObj.isPrimary())
					phone.setFlagIdRef(FLAG_PRIMARY_PHONE_NUMBER);
				else
					phone.setFlagIdRef(FLAG_SECONDARY_PHONE_NUMBER);
				if (commonUtility.isNum(listObj.getPhoneNumber()))
					key.setPhoneNumber(commonUtility.extractPhoneNumberFromString(listObj.getPhoneNumber()));
				else
					key.setPhoneNumber(null);
				phone.setTimeStmpAdd(carryDTO.getTimeStmpAdd());
				phone.setTimeStmpUpd(carryDTO.getTimeStmpUpd());
				phone.setPhoneKey(key);
				phoneNumbers.add(phone);
			}
			phoneNumbersRepository.saveAll(phoneNumbers);
		}

	}

}
