package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/*
 * SQL> CREATE TABLE BOARD (BNO NUMBER(*) constraint board)
 * 
 * CREATE TABLE board (
	BNO NUMBER(8) constraint board_bno_pk primary key,
	WRITER VARCHAR2(20),
	TITLE VARCHAR2(200),
	CONTENTS CLOB,
	REGDATE DATE,
	HITS NUMBER(5),
	ip char(16),
	status number(3));
  
 */


public class BoardVO {
   private int bno;
   private String writer;
   private String title;
   private String contents;
   private String regdate;
   private int hits;
   private String ip;
   private int status;
}