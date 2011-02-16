package createzip

class CreateZipTagLib {

	def zipdirectory = { attrs, body ->
		def dir = attrs.remove('dir')
		def filename = attrs.remove('filename')
		def stripdir = attrs.remove('stripdir')

		out << g.link(controller: "zip",
				action: "directory",  params: [dir: dir, filename: filename, stripdir: stripdir])
	}
}
