package std.fle._10_security;

import org.springframework.stereotype.Service;

import fle.toolBox.security.bcrypt.PassWord;

@Service
public class PassEncoderImplemented implements PassEncoder {

	@Override
	public String hashedPassWord(String toHash) {
		PassWord encoder = new PassWord();
		return encoder.encode(toHash);
	}

}
