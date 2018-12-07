#!/usr/bin/env perl

use Tk;
use strict;
use warnings;
use v5.10;

my $main_window = MainWindow->new;

$main_window->Label(-text => 'Fluxbox Menu Config')->pack;

$main_window->Button(
	-text => 'Add Menu',
	-command => sub{})->pack;

$main_window->Button(
	-text => 'Add Menu Item',
	-command => sub{})->pack;
MainLoop;

1;