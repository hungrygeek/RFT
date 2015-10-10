<?php
	// default memory limit 128M is not enough.
	ini_set('memory_limit','512M');
	date_default_timezone_set('Europe/London');
	//$file_loc = '\RFTdata\continuum.txt'
	$lines = file("continuum.txt", FILE_IGNORE_NEW_LINES);
	$termstartdate = "2014-04-22 00:00:00.000";
	$current_date = date("Y-m-d",strtotime("-31 day"));
	$last_week = date("Y-m-d",strtotime("-38 day"));
	$twoweek_ago = date("Y-m-d",strtotime("-45 day"));
	$day_1 = date("Y-m-d",strtotime("-32 day"));
	$day_2 = date("Y-m-d",strtotime("-33 day"));
	$day_3 = date("Y-m-d",strtotime("-34 day"));
	$day_4 = date("Y-m-d",strtotime("-35 day"));
	$day_5 = date("Y-m-d",strtotime("-36 day"));
	$day_6 = date("Y-m-d",strtotime("-37 day"));

	print_r($current_date);

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
			if ((date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($current_date)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($current_date)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($current_date)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($day_1)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($day_1)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($day_1)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($day_2)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($day_2)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($day_2)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($day_3)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($day_3)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($day_3)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($day_4)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($day_4)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($day_4)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($day_5)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($day_5)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($day_5)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($day_6)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($day_6)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($day_6)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($last_week)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($last_week)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($last_week)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 12:00:00.000")) 
					|| date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
				)) ||

				(date('Y',strtotime($tempvalue[2]))==date('Y',strtotime($twoweek_ago)) && 
				date('m',strtotime($tempvalue[2]))==date('m',strtotime($twoweek_ago)) && 
				date('d',strtotime($tempvalue[2]))==date('d',strtotime($twoweek_ago)) &&
				(
					date('H',strtotime($tempvalue[2]))==date('H',strtotime("2014-09-28 23:00:00.000")) 
					 
				))
				
				

				) {
				array_push($usefuldata, $tempvalue);
				//echo $tempvalue; 
			}
	}
	//print_r($usefuldata);

	
	$alljsonout = json_encode($usefuldata);
	$filename = 'rawdata.txt';
	//fwrite($fileoutput, $alljsonout);


	if (is_writable($filename)) {

    // In our example we're opening $filename in append mode.
    // The file pointer is at the bottom of the file hence
    // that's where $somecontent will go when we fwrite() it.
    if (!$handle = fopen($filename, 'w')) {
         echo "Cannot open file ($filename)";
         //exit;
    }

    // Write $somecontent to our opened file.
    if (fwrite($handle, $alljsonout) === FALSE) {
        echo "Cannot write to file ($filename)";
        //exit;
    }

    echo "Success, wrote to file ($filename)";

    fclose($handle);

	} else {
    	echo "The file $filename is not writable";
	}


	//echo $alljsonout;
	//file_put_contents('rawdata.txt', $alljsonout);
	


?>