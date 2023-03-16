(defproject movie-store "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [compojure "1.7.0"]
                 [ring "1.8.1"]
                 [uncomplicate/neanderthal "0.45.0"]
                 [org.clojure/java.jdbc "0.3.0-alpha5"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [ring-basic-authentication "1.0.5"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler movie-store.core/app}
  :main ^:skip-aot movie-store.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev
             {:dependencies [[midje "1.10.9"]
                             [criterium "0.4.6"]]
              :plugins      [[lein-midje "3.2.1"]]}}
  )
