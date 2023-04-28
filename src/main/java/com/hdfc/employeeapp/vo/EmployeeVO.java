package com.hdfc.employeeapp.vo;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeVO {

    @Id
    private long employeeId;
    private String employeeName;
    private String dateOfBirth;

    private static final String ALGORITHM = "AES";
    private static final String KEY = "09876543210987654321098765432109";

    public static String encryptCode(String getinput) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(getinput.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}