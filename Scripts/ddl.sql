-- 학생관리
DROP SCHEMA IF EXISTS `student`;

-- 학생관리
CREATE SCHEMA `student`;

-- 학생정보
CREATE TABLE `student`.`codes` (
	`no`       INT         NOT NULL COMMENT '학번', -- 학번
	`name`     VARCHAR(20) NOT NULL COMMENT '이름', -- 이름
	`birthday` INT         NOT NULL COMMENT '생년월일', -- 생년월일
	`social`   INT         NOT NULL COMMENT '주민번호 뒷자리', -- 주민번호 뒷자리
	`dayno`    INT         NULL     COMMENT '주야', -- 주야
	`deptno`   INT         NULL     COMMENT '학과', -- 학과
	`grade`    INT         NULL     COMMENT '학년', -- 학년
	`atdno`    CHAR(10)    NULL     COMMENT '재학', -- 재학
	`miltno`   CHAR(10)    NULL     COMMENT '병역' -- 병역
)
COMMENT '학생정보';

-- 학생정보
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `PK_codes` -- 학생정보 기본키
		PRIMARY KEY (
			`no` -- 학번
		);

-- 학생성적
CREATE TABLE `student`.`scores` (
	`no`    INT NOT NULL COMMENT '학번', -- 학번
	`subno` INT NOT NULL COMMENT '과목 코드', -- 과목 코드
	`score` INT NULL     COMMENT '점수' -- 점수
)
COMMENT '학생성적';

-- 학생성적
ALTER TABLE `student`.`scores`
	ADD CONSTRAINT `PK_scores` -- 학생성적 기본키
		PRIMARY KEY (
			`no`,    -- 학번
			`subno`  -- 과목 코드
		);

-- 병역
CREATE TABLE `student`.`militarys` (
	`miltno`   CHAR(10) NOT NULL COMMENT '병역 코드', -- 병역 코드
	`military` CHAR(10) NOT NULL COMMENT '병역 구분' -- 병역 구분
)
COMMENT '병역';

-- 병역
ALTER TABLE `student`.`militarys`
	ADD CONSTRAINT `PK_militarys` -- 병역 기본키
		PRIMARY KEY (
			`miltno` -- 병역 코드
		);

-- 학적
CREATE TABLE `student`.`attendings` (
	`atdno`     CHAR(10) NOT NULL COMMENT '재학 코드', -- 재학 코드
	`attending` CHAR(10) NOT NULL COMMENT '재학 구분' -- 재학 구분
)
COMMENT '학적';

-- 학적
ALTER TABLE `student`.`attendings`
	ADD CONSTRAINT `PK_attendings` -- 학적 기본키
		PRIMARY KEY (
			`atdno` -- 재학 코드
		);

-- 주야구분
CREATE TABLE `student`.`days` (
	`dayno` INT      NOT NULL COMMENT '주야 코드', -- 주야 코드
	`day`   CHAR(10) NOT NULL COMMENT '주야 구분' -- 주야 구분
)
COMMENT '주야구분';

-- 주야구분
ALTER TABLE `student`.`days`
	ADD CONSTRAINT `PK_days` -- 주야구분 기본키
		PRIMARY KEY (
			`dayno` -- 주야 코드
		);

-- 학과
CREATE TABLE `student`.`department` (
	`deptno`   INT         NOT NULL COMMENT '학과 코드', -- 학과 코드
	`deptname` VARCHAR(20) NOT NULL COMMENT '학과 구분' -- 학과 구분
)
COMMENT '학과';

-- 학과
ALTER TABLE `student`.`department`
	ADD CONSTRAINT `PK_department` -- 학과 기본키
		PRIMARY KEY (
			`deptno` -- 학과 코드
		);

-- 성적등급
CREATE TABLE `student`.`ranking` (
	`rank`    CHAR(5) NOT NULL COMMENT '평어', -- 평어
	`ranksoc` DOUBLE  NULL     COMMENT '평점', -- 평점
	`lowsoc`  INT     NULL     COMMENT '최소실점수', -- 최소실점수
	`hisoc`   INT     NULL     COMMENT '최대실점수' -- 최대실점수
)
COMMENT '성적등급';

-- 성적등급
ALTER TABLE `student`.`ranking`
	ADD CONSTRAINT `PK_ranking` -- 성적등급 기본키
		PRIMARY KEY (
			`rank` -- 평어
		);

-- 과목
CREATE TABLE `student`.`subiects` (
	`subno`   INT         NOT NULL COMMENT '과목 코드', -- 과목 코드
	`subiect` VARCHAR(10) NULL     COMMENT '과복 구분' -- 과복 구분
)
COMMENT '과목';

-- 과목
ALTER TABLE `student`.`subiects`
	ADD CONSTRAINT `PK_subiects` -- 과목 기본키
		PRIMARY KEY (
			`subno` -- 과목 코드
		);

-- 학생정보
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_attendings_TO_codes` -- 학적 -> 학생정보
		FOREIGN KEY (
			`atdno` -- 재학
		)
		REFERENCES `student`.`attendings` ( -- 학적
			`atdno` -- 재학 코드
		);

-- 학생정보
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_militarys_TO_codes` -- 병역 -> 학생정보
		FOREIGN KEY (
			`miltno` -- 병역
		)
		REFERENCES `student`.`militarys` ( -- 병역
			`miltno` -- 병역 코드
		);

-- 학생정보
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_department_TO_codes` -- 학과 -> 학생정보
		FOREIGN KEY (
			`deptno` -- 학과
		)
		REFERENCES `student`.`department` ( -- 학과
			`deptno` -- 학과 코드
		);

-- 학생정보
ALTER TABLE `student`.`codes`
	ADD CONSTRAINT `FK_days_TO_codes` -- 주야구분 -> 학생정보
		FOREIGN KEY (
			`dayno` -- 주야
		)
		REFERENCES `student`.`days` ( -- 주야구분
			`dayno` -- 주야 코드
		);

-- 학생성적
ALTER TABLE `student`.`scores`
	ADD CONSTRAINT `FK_codes_TO_scores` -- 학생정보 -> 학생성적
		FOREIGN KEY (
			`no` -- 학번
		)
		REFERENCES `student`.`codes` ( -- 학생정보
			`no` -- 학번
		)
		on update cascade ;

-- 학생성적
ALTER TABLE `student`.`scores`
	ADD CONSTRAINT `FK_subiects_TO_scores` -- 과목 -> 학생성적
		FOREIGN KEY (
			`subno` -- 과목 코드
		)
		REFERENCES `student`.`subiects` ( -- 과목
			`subno` -- 과목 코드
		);
		
	
-- 사용자생성
grant all
	on student.*
	to 'user_student'@'localhost' identified by 'rootroot';
	