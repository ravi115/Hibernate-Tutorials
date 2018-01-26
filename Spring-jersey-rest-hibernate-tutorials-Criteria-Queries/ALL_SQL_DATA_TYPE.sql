create table `ALL_SQL_data_type` (

	`Int_data_type` integer not null auto_increment, 
	`Long_data_type` bigint, 
	`Boolean_data_type` bit, 
	`Byte_data_type` tinyint, 
	`Char_data_type` char(1), 
	`date` date, 
	`TimeStamp` datetime, 
	`Float_data_type` float, 
	`Stirng_data_type` varchar(255), 
	`Double_data_type` double precision, 
	`Short_data_type` smallint, 
	`time` time, 
	primary key (`Int_data_type`)
    
) engine=MyISAM;