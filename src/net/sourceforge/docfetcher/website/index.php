#!/usr/bin/php
<?
# Expected variable substitution:
# "de" => "de/index.html",
# "en" => "en/index.html",
# ...
$sites = array(
	${languages}
);

$langs = explode(",", $_SERVER['HTTP_ACCEPT_LANGUAGE']);

foreach ($langs as $lang) {
	$lang = strtolower(substr(chop($lang), 0, 2));
	if (array_key_exists($lang, $sites)) {
		header("Location: ".$sites[$lang]);
		return;
	}
}

header("Location: ".$sites["en"]);
?>
