/**
 * 
 */$('#summernote').summernote(
				{
					placeholder : 'Hello stand alone ui',
					tabsize : 2,
					height : 300, // set editor height
					minHeight : null, // set minimum height of editor
					maxHeight : null,
					lang : 'utf-8',// set maximum height of editor
					focus : true, // set focus to editable area after initializing summernote
					codemirror : { // codemirror options
						theme : 'monokai'
					},
					popover : {
						air : [ [ 'color', [ 'color' ] ],
								[ 'font', [ 'bold', 'underline', 'clear' ] ] ]
					}
				});