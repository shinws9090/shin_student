-- �л�����
DROP SCHEMA IF EXISTS `student`;

-- �л�����
CREATE SCHEMA `student`;

-- �л�����
CREATE TABLE `student`.`codes` (
	`no`     INT      NOT NULL COMMENT '�й�', -- �й�
	`dayno`  INT      NULL     COMMENT '�־�', -- �־�
	`deptno` INT      NULL     COMMENT '�а�', -- �а�
	`grade`  INT      NULL     COMMENT '�г�', -- �г�
	`atdno`  CHAR(10) NULL     COMMENT '����', -- ����
	`miltno` CHAR(10) NULL     COMMENT '����' -- ����
)
COMMENT '�л�����';

-- �л�����
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `PK_codes` -- �л����� �⺻Ű
		PRIMARY KEY (
			`no` -- �й�
		);

-- �л�����
CREATE TABLE `student`.`scores` (
	`no`   INT NOT NULL COMMENT '�й�', -- �й�
	`kor`  INT NULL     COMMENT '1����', -- 1����
	`eng`  INT NULL     COMMENT '2����', -- 2����
	`math` INT NULL     COMMENT '3����' -- 3����
)
COMMENT '�л�����';

-- �л�����
ALTER TABLE `student`.`scores`
	ADD CONSTRAINT `PK_scores` -- �л����� �⺻Ű
		PRIMARY KEY (
			`no` -- �й�
		);

-- ����
CREATE TABLE `student`.`militarys` (
	`miltno`   CHAR(10) NOT NULL COMMENT '���� �ڵ�', -- ���� �ڵ�
	`military` CHAR(10) NOT NULL COMMENT '���� ����' -- ���� ����
)
COMMENT '����';

-- ����
ALTER TABLE `student`.`militarys`
	ADD CONSTRAINT `PK_militarys` -- ���� �⺻Ű
		PRIMARY KEY (
			`miltno` -- ���� �ڵ�
		);

-- ����
CREATE TABLE `student`.`attendings` (
	`atdno`     CHAR(10) NOT NULL COMMENT '���� �ڵ�', -- ���� �ڵ�
	`attending` CHAR(10) NOT NULL COMMENT '���� ����' -- ���� ����
)
COMMENT '����';

-- ����
ALTER TABLE `student`.`attendings`
	ADD CONSTRAINT `PK_attendings` -- ���� �⺻Ű
		PRIMARY KEY (
			`atdno` -- ���� �ڵ�
		);

-- �л���������
CREATE TABLE `student`.`students` (
	`no`       INT         NOT NULL COMMENT '�й�', -- �й�
	`name`     VARCHAR(20) NOT NULL COMMENT '�̸�', -- �̸�
	`birthday` INT         NOT NULL COMMENT '�������', -- �������
	`social`   INT         NOT NULL COMMENT '�ֹι�ȣ ���ڸ�' -- �ֹι�ȣ ���ڸ�
)
COMMENT '�л���������';

-- �л���������
ALTER TABLE `student`.`students`
	ADD CONSTRAINT `PK_students` -- �л��������� �⺻Ű
		PRIMARY KEY (
			`no` -- �й�
		);

-- �־߱���
CREATE TABLE `student`.`days` (
	`dayno` INT      NOT NULL COMMENT '�־� �ڵ�', -- �־� �ڵ�
	`day`   CHAR(10) NOT NULL COMMENT '�־� ����' -- �־� ����
)
COMMENT '�־߱���';

-- �־߱���
ALTER TABLE `student`.`days`
	ADD CONSTRAINT `PK_days` -- �־߱��� �⺻Ű
		PRIMARY KEY (
			`dayno` -- �־� �ڵ�
		);

-- �а�
CREATE TABLE `student`.`department` (
	`deptno`   INT         NOT NULL COMMENT '�а� �ڵ�', -- �а� �ڵ�
	`deptname` VARCHAR(20) NOT NULL COMMENT '�а� ����' -- �а� ����
)
COMMENT '�а�';

-- �а�
ALTER TABLE `student`.`department`
	ADD CONSTRAINT `PK_department` -- �а� �⺻Ű
		PRIMARY KEY (
			`deptno` -- �а� �ڵ�
		);

-- �������
CREATE TABLE `student`.`ranking` (
	`rank`    CHAR(5) NOT NULL COMMENT '���', -- ���
	`ranksoc` DOUBLE  NULL     COMMENT '����', -- ����
	`lowsoc`  INT     NULL     COMMENT '�ּҽ�����', -- �ּҽ�����
	`hisoc`   INT     NULL     COMMENT '�ִ������' -- �ִ������
)
COMMENT '�������';

-- �������
ALTER TABLE `student`.`ranking`
	ADD CONSTRAINT `PK_TABLE` -- ranking �⺻Ű
		PRIMARY KEY (
			`rank` -- ���
		);	
	
-- �л�����
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_attendings_TO_codes` -- ���� -> �л�����
		FOREIGN KEY (
			`atdno` -- ����
		)
		REFERENCES `student`.`attendings` ( -- ����
			`atdno` -- ���� �ڵ�
		);

-- �л�����
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_militarys_TO_codes` -- ���� -> �л�����
		FOREIGN KEY (
			`miltno` -- ����
		)
		REFERENCES `student`.`militarys` ( -- ����
			`miltno` -- ���� �ڵ�
		);

-- �л�����
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_students_TO_codes` -- �л��������� -> �л�����
		FOREIGN KEY (
			`no` -- �й�
		)
		REFERENCES `student`.`students` ( -- �л���������
			`no` -- �й�
		);

-- �л�����
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_department_TO_codes` -- �а� -> �л�����
		FOREIGN KEY (
			`deptno` -- �а�
		)
		REFERENCES `student`.`department` ( -- �а�
			`deptno` -- �а� �ڵ�
		);

-- �л�����
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_days_TO_codes` -- �־߱��� -> �л�����
		FOREIGN KEY (
			`dayno` -- �־�
		)
		REFERENCES `student`.`days` ( -- �־߱���
			`dayno` -- �־� �ڵ�
		);

-- �л�����
ALTER TABLE `student`.`scores`
	ADD CONSTRAINT `FK_codes_TO_scores` -- �л����� -> �л�����
		FOREIGN KEY (
			`no` -- �й�
		)
		REFERENCES `student`.`codes` ( -- �л�����
			`no` -- �й�
		);
		
	
-- ��������
grant all
	on student.*
	to 'user_student'@'localhost' identified by 'rootroot';
	