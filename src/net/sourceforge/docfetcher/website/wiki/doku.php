<?php
/*
This script redirects from the older DocFetcher wiki based on DokuWiki to the
one that's based on Apache Allura and provided by SourceForge.net.
How to use: Replace the doku.php file in the root of the DokuWiki installation
with this script. Make sure the new file has the same owner and permissions as
the old one.
*/
$base_url = "https://sourceforge.net/p/docfetcher/wiki/";
if (array_key_exists("id", $_GET)) {
	switch ($_GET["id"]) {
		case "changelog":
			header("Location: " . $base_url . "ChangeLog");
			break;
		case "changes_in_v1.1":
			header("Location: " . $base_url . "Changes%20in%20v1.1");
			break;
		case "credits":
			header("Location: " . $base_url . "Credits");
			break;
		case "docfetcher_pro":
			header("Location: " . "https://docfetcherpro.com/");
			break;
		case "faq":
			header("Location: " . $base_url . "FAQ");
			break;
		case "license":
			header("Location: " . $base_url . "License");
			break;
		case "source_code":
			header("Location: " . $base_url . "Source%20code");
			break;
		case "start":
			header("Location: " . $base_url);
			break;
		case "tips_tricks":
			header("Location: " . $base_url . "Tips%20%26%20tricks");
			break;
		case "translations":
			header("Location: " . $base_url);
			break;
		case "user_contributions":
			header("Location: " . $base_url);
			break;
		default:
			header("Location: " . $base_url);
	}
} else {
	header("Location: " . $base_url);
}
?>
