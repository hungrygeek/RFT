<?php
	// default memory limit 128M is not enough.
	ini_set('memory_limit','512M');
	date_default_timezone_set('Europe/London');
	$lines = file("continuum.txt", FILE_IGNORE_NEW_LINES);
	$termstartdate = "2014-04-22 00:00:00.000";
	$current_date = date("Y-m-d",strtotime("-1 day"));
	$last_week = date("Y-m-d",strtotime("-8 day"));
	$twoweek_ago = date("Y-m-d",strtotime("-15 day"));
	$day_1 = date("Y-m-d",strtotime("-2 day"));
	$day_2 = date("Y-m-d",strtotime("-3 day"));
	$day_3 = date("Y-m-d",strtotime("-4 day"));
	$day_4 = date("Y-m-d",strtotime("-5 day"));
	$day_5 = date("Y-m-d",strtotime("-6 day"));
	$day_6 = date("Y-m-d",strtotime("-7 day"));



	$usefuldata = array();

	
	/* this function turn a line of the raw data into an array of 3 elements: 
	Room[0],Num[1],DateObject[2] in PHP
	*/
	function explosion(&$item, $key)
	{
    	$item = explode("\t", $item);

	}
	// map explosion to every line.
	array_walk_recursive($lines, 'explosion');


	$matching = array(
		"RmE01KWH" => "Theo Matt", 
		"RmE02KWH" => "Jamn Nakami", 
		"RmE03KWH" => "Fay Davies", 
		"RmE04KWH" => "D. H. Soves", 
		"RmE05KWH" => "B P Langslow", 
		"RmE06KWH" => "H Ahmed", 
		"RmE07KWH" => "", 
		"RmE08KWH" => "TM Beaven", 
		"RmE09KWH" => "Josie Roberts", 
		"RmE10KWH" => "Lydin Hudon", 
		"RmE11KWH" => "Sarah Thomson", 
		"RmE12KWH" => "Thomas Cowie", 
		"RmE13KWH" => "Hannah Mills", 
		"RmE14KWH" => "Jas Birk", 
		"RmE15KWH" => "", 
		"RmE16KWH" => "Charlotte Britton", 
		"RmE17KWH" => "Calnona Parry", 
		"RmE18KWH" => "Oliva Capewell", 
		"RmE19KWH" => "Natalie Spong", 
		"RmE20KWH" => "", 
		"RmE21KWH" => "Oliven Mesley", 
		"RmE22KWH" => "Biko Agezino", 	
		"RmE23KWH" => "", 
		"RmE24KWH" => "Dan Brown", 
	);


	foreach ($lines as $tempvalue) {
			if (date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) &&
				(date('d',strtotime($tempvalue[2]))==date('H',12) || date('d',strtotime($tempvalue[2]))==date('H',23))

				) {
				array_push($usefuldata, $tempvalue);
				//echo $tempvalue; 
			}
	}

	$RmE01 = array();
	for ($i = 0; $i <= 23; $i++) { 
		foreach ($usefuldata as $tempvalue) {
			if ($tempvalue[0] == 'RmE01KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
				array_push($RmE01, $tempvalue);
			}
		}
	}

	$RmE02 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE02KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE02, $tempvalue);
		}
	}
	}	

	$RmE03 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE03KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE03, $tempvalue);
		}
	}
	}
	
	$RmE04 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE04KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE04, $tempvalue);
		}
	}
	}

	$RmE05 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE05KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i ) {
			array_push($RmE05, $tempvalue);
		}
	}
	}

	$RmE06 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE06KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE06, $tempvalue);
		}
	}
	}	

/*
	$RmE07 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($lines as $tempvalue) {
		if ($tempvalue[0] == 'RmE07KWH' && date('Y',strtotime($tempvalue[2]))==$current_date[year] && date('m',strtotime($tempvalue[2]))==$current_date[month] && date('d',strtotime($tempvalue[2]))==$current_date[day] && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE07, $tempvalue);
		}
	}
	}
*/


	$RmE08 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE08KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE08, $tempvalue);
		}
	}
	}

	$RmE09 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE09KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE09, $tempvalue);
		}
	}
	}

	$RmE10 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE10KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i ) {
			array_push($RmE10, $tempvalue);
		}
	}
	}

	$RmE11 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE11KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE11, $tempvalue);
		}
	}
	}

	$RmE12 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE12KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE12, $tempvalue);
		}
	}
	}

	$RmE13 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE13KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE13, $tempvalue);
		}
	}
	}

	$RmE14 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE14KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE14, $tempvalue);
		}
	}
	}
/*
	$RmE15 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($lines as $tempvalue) {
		if ($tempvalue[0] == 'RmE15KWH' && date('Y',strtotime($tempvalue[2]))==$current_date[year] && date('m',strtotime($tempvalue[2]))==$current_date[month] && date('d',strtotime($tempvalue[2]))==$current_date[day] && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE15, $tempvalue);
		}
	}
	}
*/


	$RmE16 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE16KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE16, $tempvalue);
		}
	}
	}

	$RmE17 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE17KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE17, $tempvalue);
		}
	}
	}

	$RmE18 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE18KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE18, $tempvalue);
		}
	}
	}

	$RmE19 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE19KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE19, $tempvalue);
		}
	}
	}
/*
	$RmE20 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($lines as $tempvalue) {
		if ($tempvalue[0] == 'RmE20KWH' && date('Y',strtotime($tempvalue[2]))==$current_date[year] && date('m',strtotime($tempvalue[2]))==$current_date[month] && date('d',strtotime($tempvalue[2]))==$current_date[day] && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE20, $tempvalue);
		}
	}
	}
*/


	$RmE21 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE21KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE21, $tempvalue);
		}
	}
	}

	$RmE22 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE22KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE22, $tempvalue);
		}
	}
	}

/*
	$RmE23 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($lines as $tempvalue) {
		if ($tempvalue[0] == 'RmE23KWH' && date('Y',strtotime($tempvalue[2]))==$current_date[year] && date('m',strtotime($tempvalue[2]))==$current_date[month] && date('d',strtotime($tempvalue[2]))==$current_date[day] && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE23, $tempvalue);
		}
	}
	}
*/


	$RmE24 = array();
	for ($i = 0; $i <= 23; $i++) { 
	foreach ($usefuldata as $tempvalue) {
		if ($tempvalue[0] == 'RmE24KWH' && date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) && date('H',strtotime($tempvalue[2]))==$i) {
			array_push($RmE24, $tempvalue);
		}
	}
	}


	//print_r($RmE03); 
	//print_r($current_date);
/*	$jsonoutput = '';
	$prefix = '';
	$jsonoutput .= "{\n";
	$jsonoutput .= ' "room": ' . '"E03"' . "," . "\n" ;
  	$jsonoutput .= ' "name": ' . '""' . ',' . "\n";
  	$jsonoutput .= ' "historyChart": ' . "[\n" ;

	foreach ($RmE03 as $prejson) {
		$jsonoutput .= $prefix . " {\n";

 		$jsonoutput .= '  "time": ' .'"'. date(DATE_ATOM,strtotime($prejson[2])) . '",' . "\n";
 		$jsonoutput .= '  "kw": ' . $prejson[1] . '' . "\n";

		$jsonoutput .= " }";
		$prefix = ",\n";
	}
	$jsonoutput .= "\n]";
	$jsonoutput .= "\n}";
	*/
	$hisout = '';


	function findhourread($inputarray,$i){
		foreach ($inputarray as $hourcheck) {
			if (date('H',strtotime($hourcheck[2]))==$i){
				$read = $hourcheck[1];
			}
		}
		return $read;
	}

	$min = array();
	foreach ($lines as $tempvalue1) {
		if ($tempvalue1[2] == $termstartdate) {
			$min[$tempvalue1[0]] = $tempvalue1[1]; 
		}
	}

	$max = array();
	foreach ($lines as $tempvalue2) {
		if (date('Y-m-d',strtotime($tempvalue2[2])) == date("Y-m-d",strtotime("-1 day"))) {
			$max[$tempvalue1[0]] = $tempvalue1[1]; 
		}
	}

	$rankarray = array();
	$rankarray["Theo Matt"] = abs($max["RmE01KWH"] - $min["RmE01KWH"]);
	$rankarray["Jamn Nakami"] = abs($max["RmE02KWH"] - $min["RmE02KWH"]);
	$rankarray["Fay Davies"] = abs($max["RmE03KWH"] - $min["RmE03KWH"]);
	$rankarray["D. H. Soves"] = abs($max["RmE04KWH"] - $min["RmE04KWH"]);
	$rankarray["B P Langslow"] = abs($max["RmE05KWH"] - $min["RmE05KWH"]);
	$rankarray["H Ahmed"] = abs($max["RmE06KWH"] - $min["RmE06KWH"]);
//	$rankarray["RmE07_term"] = abs($max["RmE07KWH"] - $min["RmE07KWH"]);
	$rankarray["TM Beaven"] = abs($max["RmE08KWH"] - $min["RmE08KWH"]);
	$rankarray["Josie Roberts"] = abs($max["RmE09KWH"] - $min["RmE09KWH"]);
	$rankarray["Lydin Hudon"] = abs($max["RmE10KWH"] - $min["RmE10KWH"]);
	$rankarray["Sarah Thomson"] = abs($max["RmE11KWH"] - $min["RmE11KWH"]);
	$rankarray["Thomas Cowie"] = abs($max["RmE12KWH"] - $min["RmE12KWH"]);
	$rankarray["Hannah Mills"] = abs($max["RmE13KWH"] - $min["RmE13KWH"]);
	$rankarray["Jas Birk"] = abs($max["RmE14KWH"] - $min["RmE14KWH"]);
//	$rankarray["RmE15_term"] = abs($max["RmE15KWH"] - $min["RmE15KWH"]);
	$rankarray["Charlotte Britton"] = abs($max["RmE16KWH"] - $min["RmE16KWH"]);
	$rankarray["Calnona Parry"] = abs($max["RmE17KWH"] - $min["RmE17KWH"]);
	$rankarray["Oliva Capewell"] = abs($max["RmE18KWH"] - $min["RmE18KWH"]);
	$rankarray["Natalie Spong"] = abs($max["RmE19KWH"] - $min["RmE19KWH"]);
//	$rankarray["RmE20_term"] = abs($max["RmE20KWH"] - $min["RmE20KWH"]);
	$rankarray["Oliven Mesley"] = abs($max["RmE21KWH"] - $min["RmE21KWH"]);
	$rankarray["Biko Agezino"] = abs($max["RmE22KWH"] - $min["RmE22KWH"]);
//	$rankarray["RmE23_term"] = abs($max["RmE23KWH"] - $min["RmE23KWH"]);
	$rankarray["Dan Brown"] = abs($max["RmE24KWH"] - $min["RmE24KWH"]);
	asort($rankarray);




	//print_r($min);
	//print_r($max);
	//print_r($RmE01_term);


	function arraytojsonforhis($inputarray){
		$matching = array(
		"RmE01KWH" => "Theo Matt", 
		"RmE02KWH" => "Jamn Nakami", 
		"RmE03KWH" => "Fay Davies", 
		"RmE04KWH" => "D. H. Soves", 
		"RmE05KWH" => "B P Langslow", 
		"RmE06KWH" => "H Ahmed", 
		"RmE07KWH" => "", 
		"RmE08KWH" => "TM Beaven", 
		"RmE09KWH" => "Josie Roberts", 
		"RmE10KWH" => "Lydin Hudon", 
		"RmE11KWH" => "Sarah Thomson", 
		"RmE12KWH" => "Thomas Cowie", 
		"RmE13KWH" => "Hannah Mills", 
		"RmE14KWH" => "Jas Birk", 
		"RmE15KWH" => "", 
		"RmE16KWH" => "Charlotte Britton", 
		"RmE17KWH" => "Calnona Parry", 
		"RmE18KWH" => "Oliva Capewell", 
		"RmE19KWH" => "Natalie Spong", 
		"RmE20KWH" => "", 
		"RmE21KWH" => "Oliven Mesley", 
		"RmE22KWH" => "Biko Agezino", 	
		"RmE23KWH" => "", 
		"RmE24KWH" => "Dan Brown", 
		);
		$jsonoutput = '';
		$prefix = '';
		$roomid = $inputarray[0][0];
		$jsonoutput .= "{\n";
		$jsonoutput .= ' "room": ' .'"' . $roomid .'"' . "," . "\n" ;
  		$jsonoutput .= ' "name": ' . '"'. $matching[$roomid] .'"' . ',' . "\n";
  		$jsonoutput .= ' "historyChart": ' . "[\n" ;

	for ($i = 0; $i <= 22; $i++) {
		$jsonoutput .= $prefix . " {\n";
		$j = $i+1;
		$consump = abs(findhourread($inputarray,$j) - findhourread($inputarray,$i));

 		$jsonoutput .= '  "time": ' .'"'. date(DATE_ATOM,strtotime($inputarray[$i][2])) . '",' . "\n";
 		$jsonoutput .= '  "kw": ' . $consump . '' . "\n";

		$jsonoutput .= " }";
		$prefix = ",\n";
	}
	$jsonoutput .= $prefix . " {\n";
 	$jsonoutput .= '  "time": ' .'"'. date(DATE_ATOM,strtotime($inputarray[23][2])) . '",' . "\n";
 	$jsonoutput .= '  "kw": ' . 0 . '' . "\n";
	$jsonoutput .= " }";
	$prefix = ",\n";
	$jsonoutput .= "\n]";
	$jsonoutput .= "\n}";
	return $jsonoutput;
	}


	//print_r($RmE01);
	$hisrm01 = arraytojsonforhis($RmE01);
	$hisrm02 = arraytojsonforhis($RmE02);
	$hisrm03 = arraytojsonforhis($RmE03);
	$hisrm04 = arraytojsonforhis($RmE04);
	$hisrm05 = arraytojsonforhis($RmE05);
	$hisrm06 = arraytojsonforhis($RmE06);
//	$hisrm07 = arraytojsonforhis($RmE07);
	$hisrm08 = arraytojsonforhis($RmE08);
	$hisrm09 = arraytojsonforhis($RmE09);
	$hisrm10 = arraytojsonforhis($RmE10);
	$hisrm11 = arraytojsonforhis($RmE11);
	$hisrm12 = arraytojsonforhis($RmE12);
	$hisrm13 = arraytojsonforhis($RmE13);
	$hisrm14 = arraytojsonforhis($RmE14);
//	$hisrm15 = arraytojsonforhis($RmE15);
	$hisrm16 = arraytojsonforhis($RmE16);
	$hisrm17 = arraytojsonforhis($RmE17);
	$hisrm18 = arraytojsonforhis($RmE18);
	$hisrm19 = arraytojsonforhis($RmE19);
//	$hisrm20 = arraytojsonforhis($RmE20);
	$hisrm21 = arraytojsonforhis($RmE21);
	$hisrm22 = arraytojsonforhis($RmE22);
//	$hisrm23 = arraytojsonforhis($RmE23);
	$hisrm24 = arraytojsonforhis($RmE24);

	$alljsonout = '';
	$alljsonout .= "{\n";
	$alljsonout .= '"'."time".'"'.": " . '"' .date(DATE_ATOM, strtotime("-1 day")) . '"'.",\n";
	$alljsonout .= '"'."numRooms".'"'.": " . "24,\n";

	$alljsonout .='"'."rankingChart".'"'.": [\n";
	
	foreach ($rankarray as $key => $val) {
    	//$key = $val;

    	$alljsonout .= $prefix . " {\n";
    	$alljsonout .= '  "name": ' .'"'. $key . '",' . "\n";
 		$alljsonout .= '  "kw": ' . $val . '' . "\n";
 		$alljsonout .= " }";
		$prefix = ",\n";
	}

	$alljsonout .= "],\n";

	$alljsonout .= '"' . "historyCharts" . '"' . ": " . "[\n"; 
	//print_r($hisrm01);
	$hisout .= $hisrm01;
	$hisout .= ",\n";
	$hisout .= $hisrm02;
	$hisout .= ",\n";
	$hisout .= $hisrm03;
	$hisout .= ",\n";
	$hisout .= $hisrm04;
	$hisout .= ",\n";
	$hisout .= $hisrm05;
	$hisout .= ",\n";
	$hisout .= $hisrm06;
	$hisout .= ",\n";
//	$hisout .= $hisrm07;
//	$hisout .= ",\n";
	$hisout .= $hisrm08;
	$hisout .= ",\n";
	$hisout .= $hisrm09;
	$hisout .= ",\n";
	$hisout .= $hisrm10;
	$hisout .= ",\n";
	$hisout .= $hisrm11;
	$hisout .= ",\n";
	$hisout .= $hisrm12;
	$hisout .= ",\n";
	$hisout .= $hisrm13;
	$hisout .= ",\n";
	$hisout .= $hisrm14;
	$hisout .= ",\n";
//	$hisout .= $hisrm15;
//	$hisout .= ",\n";
	$hisout .= $hisrm16;
	$hisout .= ",\n";
	$hisout .= $hisrm17;
	$hisout .= ",\n";
	$hisout .= $hisrm18;
	$hisout .= ",\n";
	$hisout .= $hisrm19;
	$hisout .= ",\n";
//	$hisout .= $hisrm20;
//	$hisout .= ",\n";
	$hisout .= $hisrm21;
	$hisout .= ",\n";
	$hisout .= $hisrm22;
	$hisout .= ",\n";
//	$hisout .= $hisrm23;
//	$hisout .= ",\n";
	$hisout .= $hisrm24;
	$alljsonout .= $hisout;
	$alljsonout .= "\n]";
	$alljsonout .= "}";
	//echo $alljsonout;
	file_put_contents('currentdata.html', $alljsonout);


?>