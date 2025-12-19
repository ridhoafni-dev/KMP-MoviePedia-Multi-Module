import SwiftUI
import Shared

import SearchUi

struct ContentView: View {
    @State private var showContent = false
    var body: some View {
        VStack {
            SearchView { movieId in }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
